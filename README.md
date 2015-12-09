This is your new Play application
=================================

This file will be packaged with your application, when using `activator dist`.

# Contributing
In order to contribute to the project, please fork the repository, add the
functionality you want, or fix any bug you like, and send a pull request to the
main repository, which is hosted here:[https://bitbucket.org/craftsmanshiptoledo/katangapp-backend](https://bitbucket.org/craftsmanshiptoledo/katangapp-backend).

Our team will work on its review and try to merge it into the `dev` branch. For
that reason, **always send the pull requests to the dev branch**, which is the
development branch for this purpose.

The `master` branch is a frozen branch, only updated with releases of the
project.

# Workspace set-up
First of all, you need to install `Play! Framework` into your machine. It is
pretty well documented in their website, so please visit it for more info:
[https://www.playframework.com/documentation/2.3.x/Installing](https://www.playframework.com/documentation/2.3.x/Installing)

As the project is based on `Play! Framework`, you should install a plugin in
your IDE. Whether you use Eclipse or IntelliJ, there are plugins that support
it. Please visit this page for more info:
[https://www.playframework.com/documentation/2.3.x/IDE](https://www.playframework.com/documentation/2.3.x/IDE)

Then, import the project into your IDE, and voilà!

# Running the application
To run the application, browse your workspace to project's folder, open a shell
and type:
``
activator run
``
It will open a port in your local machine (default is 9000), where you could
test the application: open a browser and go to `http://localhost:9000`. It
should display the default `Play! Framework` main page.

To verify the business logic of the application, go to
`http://localhost:9000/paradas`, that represents the endpoint of the service
that calculates the closest bus stops to a specific point. It needs the
following parameters to work:

 - lt: Latitude of a location (Double)
 - ln: Longitude of a location (Double)
 - r: Radius to use when searching for the closest bus stops (Integer)

In example: `http://localhost:9000/paradas?lt=39.862658&ln=-4.025088&r=500`

## Backward compatibility
To verify that the former system' business logic is working as expected, go to
`http://localhost:9000/unauto`, that represents the endpoint of the former
system. It needs the following parameters to work:

 - idl: Route identifier (String)
 - idp: Bus Stop identifier (String)
 - ido: Bus Stop Order (String)

In example: `http://localhost:9000/unauto?idl=41&idp=P001&ido=1.00000`