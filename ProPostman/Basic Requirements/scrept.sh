COLLECTION_FILE="E:\ProPostman\Basic Requirements\postman_collection.json"

newman run "$COLLECTION_FILE" \
    --reporters cli,json \
    --reporter-json-export report.json

