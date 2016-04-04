# pdfstamper

Merges two pdf files (Overlay), similar to `pdftk stamp` but using Apache PDFBox 2.

<img src="https://raw.githubusercontent.com/rmoriz/pdfstamper/master/misc/example.png">


## Usage
````

usage: pdfstamper
 -h,--help
 -i,--input <arg>      source pdf file to stamp
 -o,--output <arg>     output pdf filename
 -t,--template <arg>   template pdf file used for stamping
 -v,--version
```

```shell

wget https://raw.githubusercontent.com/rmoriz/pdfstamper/master/out/artifacts/pdfstamper_jar/pdfstamper.jar
java -jar pdfstamper.jar -i /tmp/input.pdf -t /tmp/overlay_template.pdf -o output.pdf


```

## PDF Service Filter (OSX)

`mkdir ~/Library/PDF Services`

add:

```shell
#!/bin/sh
#
#
JAVA="/Library/Internet\ Plug-Ins/JavaAppletPlugin.plugin/Contents/Home/bin/java"
STAMPER="$JAVA -jar /Users/rmoriz/Dropbox/bin/pdfstamper.jar"

$STAMPER -i "$3" -t "$TEMPLATE" -o "/tmp/$1.pdf"
open -W "/tmp/$1.pdf"

rm "$3"
rm "/tmp/$1.pdf"
```

## Related 

- https://developer.apple.com/library/mac/documentation/Printing/Conceptual/PDF_Workflow/pdfwf_concepts/pdfwf_concepts.html
- https://github.com/rmoriz/digital_stationery



## License

see `LICENSE.txt`
