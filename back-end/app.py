from flask import Flask, request, jsonify
from PIL import Image
app = Flask(__name__)

@app.route("/", methods=["POST"])
def process_image():
    file = request.files['image']
    img = Image.open(file.stream)

    return jsonify({'msg': 'success', 'size': [img.width, img.height]})


if __name__ == "__main__":
    app.run(debug=True)