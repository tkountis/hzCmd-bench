#!/usr/bin/env bash

benchDir=""
newHzVersion="master"
oldHzVersion="master"

OPTS=`getopt -o : --long  boxCount:,memberBox:,members:,clients:,duration:,ee:,machienSpec:,testDir:,hazelcastVersion:,simulatorVersion:,lab:,killBox: -n 'parse-options' -- "$@"` || { echo "Failed parsing options." >&2 ; exit 1; }

initCmdArgs () {
 eval set -- "$OPTS"

 while true; do
  case "$1" in
    --ee ) ee="$2"; shift 2 ;;
    --boxCount ) boxCount="$2"; shift 2 ;;
    --memberBox ) memberBox="$2"; shift 2 ;;
    --members ) members="$2"; shift 2 ;;
    --clients ) clients="$2"; shift 2 ;;
    --duration ) duration="$2"; shift 2  ;;
    --machienSpec ) machienSpec="$2"; shift 2  ;;
    --testDir ) testDir="$2"; shift 2  ;;
    --hazelcastVersion ) hazelcastVersion="$2"; shift 2  ;;
    --simulatorVersion ) simulatorVersion="$2"; shift 2  ;;
    --lab ) lab="$2"; shift 2 ;;
    --killBox ) killBox="$2"; shift 2 ;;
    -- ) shift; break ;;
    * ) break ;;
  esac
 done
}

setDirStruct () {
 output="$(pwd)/$(getHazelcastVersion)/$(date '+%Y_%m_%d-%H_%M_%S')"
 mkdir -p ${output}
 cp agents.txt ${output} 2>/dev/null || true
 cd ${output}
}

setSimulatorProps () {
 cp $SIMULATOR_HOME/simulator-tests/*.properties .
 cp ~/configuration/run .
 cp ~/configuration/simulator.properties .

 if [ -n "${testDir}" ]; then
   cp -fr $SIM_EE_TEST_DIR/${testDir}/. .
 fi

 if [ "$lab" == "true" ]; then
   cp -fr ~/lab/. .
   sshAll 'sudo killall -9 java'
 fi

 hzVersion=$(getHazelcastVersion)
 sed -i s/maven=.*/maven="${hzVersion}"/ simulator.properties

 if [ -n "${machienSpec}" ]; then
   sed -i "s|MACHINE_SPEC=.*|MACHINE_SPEC=${machienSpec}|" simulator.properties
 fi
}

provisionBoxes () {
 awsCreate ${boxCount} jenkins-ec2-key
 provisioner --install --uploadHazelcast --enterpriseEnabled ${ee}
 provisioner --clean
}

mainFunction () {
 initCmdArgs
 updateRepos
 setDirStruct
 setSimulatorProps
 provisionBoxes

 ./run ${boxCount} ${memberBox} ${members} ${clients} ${duration} ${ee} | tee sim-output.out  ||  exitCode=${PIPESTATUS[0]}

 lookForErrors
 exit $exitCode
}

mainFunction