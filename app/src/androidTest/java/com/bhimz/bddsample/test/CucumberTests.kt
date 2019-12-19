package com.bhimz.bddsample.test

import cucumber.api.CucumberOptions

@CucumberOptions(features = ["features"], glue = ["com.bhimz.bddsample.steps"])
class CucumberTests