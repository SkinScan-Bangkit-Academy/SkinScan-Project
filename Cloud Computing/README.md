# SkinScan-BE

This repository contains the server-side code and database setup for the SkinScan application.

## Table of Content
- [Introduction](#introduction)
- [Environment](#environment)
- [Configuration](#configuration)
- [API Documentation](api-documentation)
- [API URL](api-url)

## Introduction
SkinScan is an application for detecting skin diseases using the camera and gallery. The application also provides explanations of diseases, including drug recommendations and prevention methods, as well as articles on skin diseases.

## Environment
SkinScan Backend runs with :
1. Express JS
2. GCP App Engine
3. Firebase Authentication

## Configuration
You need these files to run the server
- .env
(you can get the key from Firebase Project Setting)
```
FIREBASE_API_KEY=
FIREBASE_AUTH_DOMAIN=
FIREBASE_PROJECT_ID=
FIREBASE_STORAGE_BUCKET=
FIREBASE_MESSAGING_SENDER_ID=
FIREBASE_APP_ID=
```
- serviceAccountKey.json
(you can get the key from Firebase Project Settings -> Service Accounts -> Firebase Admin SDK -> Generate Key)
```
{
  "type": "",
  "project_id": "",
  "private_key_id": "",
  "private_key": "",
  "client_email": "",
  "client_id": "",
  "auth_uri": "",
  "token_uri": "",
  "auth_provider_x509_cert_url": "",
  "client_x509_cert_url": "",
  "universe_domain": ""
}
```

## API Documentation
[API Documentation Link](https://documenter.getpostman.com/view/34778228/2sA3XLDPKz)
