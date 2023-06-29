#./gradlew assembleDebug -Dorg.gradle.daemon=false -Dorg.gradle.debug=true


./gradlew clean
./gradlew lancet-runtime:publishToMavenLocal
./gradlew lancet-plugin:publishToMavenLocal
./gradlew monitormodel:publishToMavenLocal
./gradlew nativehook:publishToMavenLocal

./gradlew app:assembleDebug
./gradlew app:assembleRelease