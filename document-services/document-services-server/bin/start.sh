#!/bin/bash

# TODO: change active profiles to based on the env.

CF_RUNTIME_ENV=junit

java -cp lib -jar lib/document-services-server*-bootinf.jar --spring.config.location=config --spring.profiles.active=$CF_RUNTIME_ENV

