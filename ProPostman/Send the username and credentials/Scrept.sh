newman run "E:\ProPostman\Send the username and credentials\Send the username and credentials.json" -e "E:\ProPostman\Send the username and credentials\Send cred Env.postman_environment.json" --env-var "baseurl=https://postman-echo.com/basic-auth" --env-var "username=postman" --env-var "password=password"\
    --reporters cli,json \
    --reporter-json-export report.json