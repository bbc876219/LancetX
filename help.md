#./gradlew assembleDebug -Dorg.gradle.daemon=false -Dorg.gradle.debug=true


./gradlew clean
./gradlew lancet-runtime:publishToMavenLocal
./gradlew lancet-plugin:publishToMavenLocal

./gradlew app:assembleDebug