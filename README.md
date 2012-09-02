# What is this

At the 2012 [EMF Camp](https://www.emfcamp.org/ "EMF Camp home page") I wanted a quick project
that I could build in a day and that might produce something visually appealing and recognizable.
As there is a lot or outdoor space at the camp I liked the idea of trying some
[light painting](http://en.wikipedia.org/wiki/Light_painting "Light painting - Wikipedia") - and
[Nyancat](http://www.youtube.com/watch?v=QH2-TGUlwu4 "Nyancat - YouTube") seemed an obvious
subject. The final result of the project is shown here:

<a href="http://www.flickr.com/photos/travelbot/7909002212/" title="Nyancat at EMF camp by travelbot, on Flickr"><img src="http://farm9.staticflickr.com/8441/7909002212_2c0d73c192.jpg" width="500" height="333" alt="Nyancat at EMF camp"></a>

# Construction

The project uses an Arduino and a [1m addressable RGB strip from SparkFun](https://www.sparkfun.com/products/10312
 "SparkFun - RGB LED Strip - 32 LED/m Addressable - 1m") - the strip is now discontinued but
you can find cheaper alternatives on eBay - search for 'Dream Color' or 'WS2801'. Hooking it all up
is pretty simple and is covered in SparkFun's [example code](http://www.sparkfun.com/datasheets/Components/LED/LED_Strip_Example.pde
 "SparkFun = Addressable RGB strip example code").
 
The Arduino was powered by an iPhone charger hooked up to a long main extension lead. 
 
# Code

The code is based on [SparkFun's example](http://www.sparkfun.com/datasheets/Components/LED/LED_Strip_Example.pde
 "SparkFun = Addressable RGB strip example code") and uses the [Arduiniana Flash library](http://arduiniana.org/libraries/Flash/
  "Arduiniana - Flash library") to store and retrieve the image data from the Arduino's flash memory - it's too large to
 fit into RAM).

There is also a Java program that takes a [Nyancat PNG file](https://github.com/teabot/emfcamp-nyancat/blob/master/nyan_pixel.png) and produces some Arduino code that contains an indexed image in array form.
This generated code should just be copied and pasted into the Arduino sketch.

# Producing the image

* Set up a camera on a tripod.
* Use a long exposure - 10-15 seconds is good for a single NyanCat image.
* Use a timer or a friend to trigger the shutter. 
* Walk slowly across the camera's field of view.   

# Thanks to

* [@marekventur](http://marekventur.de/) for checking my code and electronics when nothing was working.
* The EMF pixies.

