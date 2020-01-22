## Opencv Face Detection with Springboot Example

### Steps of Run

* `$ git clone https://github.com/frknikiz/opencv-facedetection.git`

* `$ cd opencv-facedetection`

* `$ mvn spring-boot:run`

### Example
* For json Response 
   
        $ curl -X POST \
           http://localhost:8080/faceDetect/json \
           -H 'content-type: multipart/form-data;' \
           -F file=@{path/to/image_file}
           
* For image response

        $ curl -X POST \
           http://localhost:8080/faceDetect/image \
           -H 'content-type: multipart/form-data;' \
           -F file=@{path/to/image_file}
           
