terraform {
  backend"gcs"{
    bucket = "pexon-training-tfstate"
    prefix = "marc-training-cicd/state"
  }
  required_providers {
    google = {
      source  = "hashicorp/google"
      version = "3.5.0"
    }
  }
}

provider "google" {
  project     = "pexon-training"
  region      = "europe-west4"
}

resource "google_sql_database_instance" "master" {
  name             = "marc-cicd-training-test3"
  database_version = "MYSQL_5_7"
  region           = "europe-west3"
  settings {
    tier = "db-f1-micro"
  }
  timeouts {
    create = "60m"
    delete = "2h"
  }
}

resource "google_cloud_run_service" "marc-spring-api" {
  name     = "cloudrun-marc"
  location = "europe-west3"

  template {
    spec {
      containers {
        image = "gcr.io/pexon-training/api-marc"
      }
    }
  }
  
}