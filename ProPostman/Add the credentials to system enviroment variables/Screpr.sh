COLLECTION_FILE="E:\ProPostman\Add the credentials to system enviroment variables\Auth_run_Command.json"
ENVIRONMENT_FILE="E:\ProPostman\Add the credentials to system enviroment variables\EnvVar.postman_environment.json"

newman run "$COLLECTION_FILE" -e "$ENVIRONMENT_FILE"\
    --reporters cli,json\
    --reporter-json-export report.json



