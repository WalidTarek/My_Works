node "E:\ProPostman\Extract to external file\config.json"  && newman run "E:\ProPostman\Extract to external file\ExtractDataToExternalFile.json" -e "E:\ProPostman\Extract to external file\env.json" \
 --reporters cli,json \
 --reporter-json-export report.json