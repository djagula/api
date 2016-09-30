# Example API Calls
### CLI Examples
If you get a status 200, you will receive a JSON list of satellite data or imagery files that match the criteria, their sizes, and signed URL to download. The signed URLs **expire 1 hour after being generated.**

**NOTE:** The API key specified (1a2b3c4d5e6f7g8h9i0j1k2l3m4n5o6p) is just an example key. 

One of the words largest landfills "Olusosun Dump" in Nigeria in August 1, 2015:

```curl -H "x-api-key: 1a2b3c4d5e6f7g8h9i0j1k2l3m4n5o6p" https://api.skywatch.co/data/time/2015-8-1/location/6.566358,3.367358,6.586358,3.387358```

**[JSON output](https://github.com/skywatchspaceapps/api/blob/master/examples/example1.json)**

Monitoring an Imperial Oil refinery in Sarnia, Canada in June 1, 2015:

```curl -H "x-api-key: 1a2b3c4d5e6f7g8h9i0j1k2l3m4n5o6p" https://api.skywatch.co/data/time/2015-6-1/location/36.281389,-80.060278/level/3```

**[JSON output](https://github.com/skywatchspaceapps/api/blob/master/examples/example2.json)**

The smoggiest city on Earth, Ahvaz, Iran in September, 2015:

```curl -H "x-api-key: 1a2b3c4d5e6f7g8h9i0j1k2l3m4n5o6p" https://api.skywatch.co/data/time/2015-9/location/31.321119,48.676074/level/1/band/red,green,blue```

**[JSON output](https://github.com/skywatchspaceapps/api/blob/master/examples/example3.json)**

Other example calls:

```curl -H "x-api-key: 1a2b3c4d5e6f7g8h9i0j1k2l3m4n5o6p" https://api.skywatch.co/data/time/2009-12-25/location/-71.1043443253471,-42.3150676015829/level/2```

**[JSON output](https://github.com/skywatchspaceapps/api/blob/master/examples/example4.json)**

```curl -H "x-api-key: 1a2b3c4d5e6f7g8h9i0j1k2l3m4n5o6p" https://api.skywatch.co/data/time/2009-12-25/location/-71.1043443253471,-42.3150676015829```

**[JSON output](https://github.com/skywatchspaceapps/api/blob/master/examples/example5.json)**

### Programmatic Examples

* [Python](https://github.com/skywatchspaceapps/api/blob/master/examples/skywatchapi_example.py)
* [Java](https://github.com/skywatchspaceapps/api/blob/master/examples/skywatchapi_example.java)
* [JavaScript using jQuery](https://github.com/skywatchspaceapps/api/blob/master/examples/skywatchapi_example.zip) (courtesy of [Rochester Institute of Technology's Space Exploration Research Group](https://sites.sg.rit.edu/spex/))
* [R wrapper](https://github.com/amsantac/SkyWatchr) (courtesy of [Ali Santacruz](https://github.com/amsantac))
