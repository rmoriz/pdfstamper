# pdfstamper

Merges two pdf files (Overlay), similar to `pdftk stamp` but using Apache PDFBox 2.

## Related 

https://github.com/rmoriz/digital_stationery


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

## License

see `LICENSE.txt`
