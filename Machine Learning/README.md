# SkinScan - ML


## Table of Contents
1. [Introduction](#Introduction)
2. [Datasets](#datasets)
3. [Model Architecture](#model-architecture)
4. [Training](#training)
5. [Evaluation](#evaluation)

## Introduction
This project involves training a neural network model for classifying skin diseases using images. The model is based on InceptionV3, a powerful architecture for image classification tasks. We will cover data preparation, model training, and evaluation processes.

## Datasets
The datasets used for training and evaluation in this project :
- [skin-diseases-image-dataset](https://www.kaggle.com/datasets/ismailpromus/skin-diseases-image-dataset)

We have 10 labels for datasets :
1. Dermatitis Atopik
2. Eksim
3. Infeksi Jamur
4. Infeksi Virus
5. Karsinoma Sel Basal
6. Kutil
7. Melanoma
8. Psoriasis
9. Tahi Lalat
10. Tumor Jinak


## Model Architecture

The model architecture is based on the pre-trained InceptionV3 network, with additional custom layers added to adapt it for our specific classification task. Key components include:

- **Pre-trained Weights**: Using pre-trained weights to leverage the knowledge learned from large-scale datasets.
- **Custom Layers**: Adding new layers to fine-tune the model for our specific dataset.
- **Fine-tuning**: Making specific layers trainable to adapt the model to our data.

## Training
The training process includes several steps to ensure effective learning:

- **Data Preparation**: Augmenting and normalizing the images to improve model robustness.
- **Training Loop**: Training the model with monitoring callbacks to optimize performance.
- **Visualization**: Plotting training and validation metrics to track progress.

## Evaluation
Evaluating the model involves assessing its performance on unseen data using various metrics:

- **Predictions**: Making predictions on the validation set.
- **Confusion Matrix**: Visualizing the confusion matrix to understand misclassifications.
- **Classification Report**: Generating a detailed report to evaluate metrics like accuracy, precision, recall, and F1 score.
