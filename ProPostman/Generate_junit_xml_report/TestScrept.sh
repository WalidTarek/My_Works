newman run "E:\ProPostman\Generate_junit_xml_report\Auth_run_Command.json" \
-e "E:\ProPostman\Generate_junit_xml_report\EnvVar.postman_environment.json" \
    --reporters cli,junit \
    --reporter-junit-export report.xml