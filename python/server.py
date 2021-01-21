#!/bin/env python3

# Our imports
from flask import Flask, send_from_directory

# Instantates the flask server
app = Flask(__name__)

# When we start the server, the file is version one by default and will incremented on the download method
version = 1

# This route is for sending a response based off data sent to it. Demonstrates basic url parameters manipulation
@app.route("/<param>", methods=["GET"])
def base_url(param):
    return f'you sent the string: {param}'

# This route is for returning the current version of the dummyfile.txt. No longer demonstrating json parsing as I forgot Java 11 doesn't have a default parser.
@app.route("/version", methods=["GET"])
def version_check():
    return str(version)

# This route is for fetching the "latest" dummyfile.txt. Demonstrates file download
@app.route("/download", methods=["GET"])
def download():
    global version
    print(f'Download endpoint hit, incrementing version from {version} to {version + 1}')
    version +=1
    return send_from_directory(directory="./download", filename="dummyfile.txt", as_attachment=True)

# Hooks into main, python looks through a script searching for the main method at the bottom of the file. This is an alternative to hook in and start the flask server.
if __name__ == "__main__":
    app.run()