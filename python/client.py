# Requests is a simple to use python3 lib for simple http tasks, we only import the get method as that's all we need for this example.
from requests import get

# This is the url parameter that we have the user input than use to demonstrate it working correctly.
param = input("Please declare a single word. Select characters are not allowed due to http, these include forward slashes, colons, and spaces (I'm not filtering your input as this is an example so expect an error):\n")

# This is the url we will be querying, it's built using F-Strings (python's string interpolation).
query_url = f'http://127.0.0.1:5000/{param}'

# This performs the get request to the specified url and saves the instantation of the response object to the variable 'response'.
response = get(url=query_url)

# Explain what we are doing from the console.
print(f'We are performing a get request on the url {query_url}')

# Demonstrate the appropriate response code from our request; this can be changed to whatever we want server side if we don't respect standard convention.
print(f'We received a response code of: {response.status_code}')

# Demonstrate the actual content of the request result. 
print(f'We received a text reponse of: "{response.text}"')

# Builds out the new url for file download.
query_url = f'http://127.0.0.1:5000/download'

# Demonstrate receiving a file from the remote server.
print(f'We are  going to perform another get request to the server at this url: {query_url}. This time we expect to get a file back.')

# This performs the get request to the specified url and saves the instantation of the response object to the variable 'response'.
response = get(query_url)

# Demonstrate the content of the file, normally wouldn't do this and would just write to a file but for quick demo this is fine and don't want extra files/clutter.
print(f'The contents of the file are:\n{response.text}')