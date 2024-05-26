#!/bin/bash
java -version
echo "y\ny\ny\ny\ny\ny\ny\ny\ny\ny\ny\ny\ny" | /opt/cmdline-tools/bin/sdkmanager --licenses --sdk_root=$WORKSPACE
export PATH=$PATH:/opt/cmdline-tools/bin
export ANDROID_HOME=/opt/cmdline-tools/bin
chmod +x ./gradlew
./gradlew assembleDebug
