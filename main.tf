terraform {
  backend "gcs" {
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
  name             = "marcinstance"
  database_version = "MYSQL_5_7"
  region           = "europe-west3"
  settings {
    tier = "db-f1-small"
  }
  timeouts {
    create = "60m"
  }
}

resource "google_sql_database" "database" {
  name      = "database_name"
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