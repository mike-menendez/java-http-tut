from flask import Flask, send_from_directory


app = Flask(__name__)

@app.route("/<param>", methods=["GET"])
def base_url(param):
    return f'you sent the string: {param}'

@app.route("/download", methods=["GET"])
def download():
    return send_from_directory(directory="./download", filename="dummyfile.txt", as_attachment=True)

if __name__ == "__main__":
    app.run()