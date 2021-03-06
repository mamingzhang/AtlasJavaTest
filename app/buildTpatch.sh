#!/bin/bash

echo "(1) 修改依赖的源码和版本"
echo "    修改App工程源码"
echo "    修改versionName"


echo "(2)  重新构建apk， 生成patch 包"

../gradlew clean assembleDebug -DapVersion=1.0.0 -DversionName=1.0.1


echo "(3) 上传 tpatch"
adb push build/outputs/tpatch-debug/update-*.json /mnt/sdcard/Android/data/com.horsege.atlastjavatest/cache/
adb push build/outputs/tpatch-debug/patch-*.tpatch /mnt/sdcard/Android/data/com.horsege.atlastjavatest/cache/

echo "(4) 点击动态部署完成安装 "
