terraform {
  backend"gcs"{
    bucket = "pexon-training-tfstate"
    prefix = "marc-training/state"
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
  name             = "marc-cicd-training-test2"
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

resource "google_sql_database" "database" {
  name      = "db_main"
  instance  = google_sql_database_instance.master.name
  charset   = "utf8"
  collation = "utf8_general_ci"
}

resource "google_sql_user" "users" {
  name     = "root"
  instance = google_sql_database_instance.master.name
  host     = "%"
  password = "root"
}

output "db_ip" {
  value = google_sql_database_instance.master.ip_address
} 