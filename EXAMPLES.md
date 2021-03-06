# Example API Calls
### Programmatic Examples

* [Python](https://github.com/skywatchspaceapps/api/blob/master/examples/skywatchapi_example.py)
* [Java](https://github.com/skywatchspaceapps/api/blob/master/examples/skywatchapi_example.java)
* [JavaScript using jQuery](https://github.com/skywatchspaceapps/api/blob/master/examples/skywatchapi_example.zip) (courtesy of [Rochester Institute of Technology's Space Exploration Research Group](https://sites.sg.rit.edu/spex/))
* [R wrapper](https://cran.r-project.org/web/packages/SkyWatchr/index.html) (courtesy of [Ali Santacruz](https://github.com/amsantac))

### CLI Examples
If you get a status 200, you will receive a JSON list of satellite data or imagery files that match the criteria, their sizes, and signed URL to download. The signed URLs **expire 1 hour after being generated.**

If downloading via `wget` ensure double qoutes (") are around the signed URL. 

**NOTE:** The API key specified (1a2b3c4d5e6f7g8h9i0j1k2l3m4n5o6p) is just an example key. 

One of the words largest landfills "Olusosun Dump" in Nigeria in August 1, 2015:

```curl -H "x-api-key: 1a2b3c4d5e6f7g8h9i0j1k2l3m4n5o6p" https://api.skywatch.co/data/time/2015-8-1/location/3.367358,6.566358,3.387358,6.586358```

*[JSON output](https://github.com/skywatchspaceapps/api/blob/master/examples/example1.json)*

Monitoring an Imperial Oil refinery in Sarnia, Canada in June 1, 2015:

```curl -H "x-api-key: 1a2b3c4d5e6f7g8h9i0j1k2l3m4n5o6p" https://api.skywatch.co/data/time/2015-6-1/location/-82.4169987,42.954811/level/3```

*[JSON output](https://github.com/skywatchspaceapps/api/blob/master/examples/example2.json)*

The smoggiest city on Earth, Ahvaz, Iran in September, 2015:

```curl -H "x-api-key: 1a2b3c4d5e6f7g8h9i0j1k2l3m4n5o6p" https://api.skywatch.co/data/time/2015-9/location/48.676074,31.321119/level/1/band/red,green,blue```

*[JSON output](https://github.com/skywatchspaceapps/api/blob/master/examples/example3.json)*

Other example calls:

```curl -H "x-api-key: 1a2b3c4d5e6f7g8h9i0j1k2l3m4n5o6p" https://api.skywatch.co/data/time/2009-12-25/location/-71.1043443253471,-42.3150676015829/level/2```

*[JSON output](https://github.com/skywatchspaceapps/api/blob/master/examples/example4.json)*

```curl -H "x-api-key: 1a2b3c4d5e6f7g8h9i0j1k2l3m4n5o6p" https://api.skywatch.co/data/time/2009-12-25/location/-71.1043443253471,-42.3150676015829```

*[JSON output](https://github.com/skywatchspaceapps/api/blob/master/examples/example5.json)*
