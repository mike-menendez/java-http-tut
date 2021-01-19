# What is this?
This is boilerplate code that I wrote in python in order to test out the functionality of both a basic http server and http client.

# How to use this?
## Setup
First thing we need to do is setup our python3 virtual enviroment.

This can be done with: `python3 -m venv $VENV_NAME`.

After we have done this, we will need to activate the venv.

For 'nix users, it will be `source $VENV_NAME/bin/activate`, Windows users, you're on your own (Hint: activate the PowerShell file (*.ps))

This will need to be done in two seperate terminal windows as we have both the server and client to run simultainously.

## Using Each
For setting up the webserver (which must be up and running before the client), we only have to invoke the server script, this should be a simple `python3 server.py` in one of the setup terminal windows.

For using the client, we make sure that the server is up and running, than we literally just invoke the client script with `python3 client.py`. 

The client script will ask for user input as that will be url parameter that will provided to the server to demonstrate url parameters and dynamic responses.