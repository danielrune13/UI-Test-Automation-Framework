## How to encrypt data:

1. Comment code in application.yaml

2. In the related yaml file, enclose all data you want to encrypt with DEC(). Eg: DEC(password123)

3. Execute the following command and change the password and file path according your preferences:

```
mvn jasypt:encrypt -Djasypt.encryptor.password="TEST_PASSWORD" -Djasypt.plugin.path="file:src/main/resources/swag-labs-config/application-test.yaml"
```

All encrypted information should now be enclosed in ENC()
______________________________________________________________________

## How to decrypt data:

1. Comment code in application.yaml

2. Execute the following command with your encryption password and related file:

```
mvn jasypt:decrypt -Djasypt.encryptor.password="TEST_PASSWORD" -Djasypt.plugin.path="file:src/main/resources/swag-labs-config/application-test.yaml"
```

Decrypted data should now be displayed in the terminal