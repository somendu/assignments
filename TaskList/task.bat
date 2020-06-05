del /F /Q  C:\FortyTwo42\Workspaces\explore\assignments\TaskList\jar\TaskList.jar

cd C:\FortyTwo42\Workspaces\explore\assignments\TaskList

gradle build --console=plain copyJar

java -jar jar\TaskList.jar
