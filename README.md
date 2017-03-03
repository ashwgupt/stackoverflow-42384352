# stackoverflow-42384352

This repo is to provide with a samplem code to recreate and prove the issue faced
as reported on [Stackoverflow](http://stackoverflow.com/questions/42384352/springboot-1-5-1-upgrade-mvc-exception-handling-issues)

## Issue recreation

Easiest way to verify is by running the test cases present in the code base using
`mvn clean verify`

The main test to look for is - showPageNotFoundWhenEndPointDoesNotExist, which
explains the behaviour under test. T

he test would pass when run with Spring Boot 1.4.4.RELEASE version but fail when
the version is switched to the latest 1.5.1.RELEASE in POM.

The another imp bit to notice is that, if `extends SpringBootServletInitializer`
is removed from the `NotFoundApplication` class, the test case would pass and
the behaviour would be as expected. That might further help zero down to potential
problematic area to look at.

For our complete usecase we have a need to `extend SpringBootServletInitializer`
while implementing the `main` class and hence the issue is inevitable.