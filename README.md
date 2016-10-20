# SkyWatch API

# Table of Contents

1. <a href="#overview">Overview</a>
2. <a href="#api">API Usage</a>
3. <a href="#results">Search Results, Limits, and Downloading the Data</a>
4. <a href="#fields">API Fields</a>
5. <a href="#examples">Example API Calls</a>
6. <a href="#documentation">Dataset Documentation</a>
7. <a href="#hdf">HDF Documentation and Resources</a>
8. <a href="#issues">Known Issues</a>
9. <a href="#troubleshooting">Troubleshooting</a>

### <h3 id="overview">Overview</h3>
Through the API you can access the following satellite imagery and climate/atmospheric datasets:
* [Landsat-8](http://www.skywatch.co/landsat8-1) (Data level: level 1 - imagery only)
* [AIRS](http://www.skywatch.co/airs) (Data level: level 2 and 3)
* [GOSAT/ACOS](http://www.skywatch.co/gosat) (Data level: level 2 and 3)
* [MOPITT](http://www.skywatch.co/mopitt) (Data level: level 1 and 3)
* [OCO-2](http://www.skywatch.co/oco2) (Data level: level 2 only)
* [TES](http://www.skywatch.co/tes) (Data level: level 2 and 3)

You can use the API to search satellite imagery and datasets by wavelength (band), cloud cover, resolution, data level, source, location, and date-time. 

API calls through the Command-Line Interface (CLI) or programmatically will return a JSON (JavaScript Object Notation) response with a signed URL to download imagery and datasets that meet the search criteria.

### <h3 id="api">API Usage</h3>
```curl -H "x-api-key: <api-key>" https://api.skywatch.co/data/time/<time-period>/location/<longitude,latitude>/source/<instrument-satellite>/level/<data-level>/resolution/<max-resolution>/cloudcover/<max-cloudcover>/band/<wavelength-band>```

**NOTE:** ```time/<time-period>``` and ```location/<coordinates>``` are the only two mandatory fields - others are optional. The order of the fields is **not important**, and fields can be omitted. 

### <h3 id="results">Search Results, Limits, and Downloading the Data</h3>

The search results from the JSON response are sorted by descending order of the date and time the image or the data were captured.

The current API limits are 1000 requests per second, and 2000 bursts per request. API calls **must** complete within 30 seconds. 

Each signed URL can be directly downloaded through a browser or programmatically, which expires **1 hour** after being generated.

### <h3 id="fields">API Fields</h3>

**api-key**

If you would like an API key please [sign-up](http://www.skywatch.co/request-access) to be added to the list. 

**time-period** 

One or two UTC timestamps in ISO format (yyyy-mm-ddThh:mm:ss.sssss+|-zzzz). Partial or complete dates and timestamps can be specified (e.g. 2009, 2009-12, 2009-12-25, 2009-12-25T13:25:00.0000+0000). If no time is specified, midnight UTC on the day in question is assumed. 

If only one timestamp is passed in, the range of one day is assumed. For example, if 2009-12-25 is specified, the search takes place as if 2009-12-25,2009-12-26 was specified. If the single timestamp is a month, that entire month is searched. For example if 2015-09 is specified, the search takes place as if midnight 2015-09-01 to midnight 2015-10-01 was specified. If a single year is specified, that entire year is searched. For example if 2015 is specified, the search takes place as if midnight 2015-01-01 to midnight 2016-01-01 was specified. 

**<longitude,latitude>**

A list of longitude, latitude coordinate pairs as a flat, comma-separated list. A list of two numbers represents a point, four numbers is a square area where the coordinates are the corners, or if there are more than four numbers the coordinates represent a closed polygon, where the first point equals the last point in the list. Because this list represents a number of points, there always has to be an even number of numbers in the list.

*Examples:* 
* Point: -71.1043443253,-42.3150676016
* Square:  -71.1043443253471,-42.3150676015829,71.1043443253471,42.3150676015829
* Polygon: 43.81173831375078,-79.69345092773438,43.51668853502909,-79.70581054687499,43.463884091369046,-79.38995361328125,43.69865837138954,-79.34463500976562,43.875128129336716,-79.34188842773438,43.81173831375078,-79.69345092773438

**instrument-satellite**

Search criteria can be specified by the source of the data - either the instrument on-board the satellite or the satellite itself. Single or multiple sources can be specified. 

Choice of sources are: *ACOS, AIRS, CAI, FTS-SWIR,  Landsat-8, MOPITT, OCO2, and TES.* This field is not case-sensitive, and multiple sources can be specified (separated by commas).

**data-level**

The data level is an optional path of the API URL that corresponds to the [data processing levels](http://science.nasa.gov/earth-science/earth-science-data/data-processing-levels-for-eosdis-data-products/) for Earth observation data. Level 1, 2, and 3 (L1, L2, L3) datasets are available. If no data level is specified, datasets of all levels will be returned. Only a single level can be specified.

Choices are: *1, 2, or 3.*

**max-resolution**

This maximum resolution field is only applicable to imagery that's available through the API (i.e. Landsat-8). Resolution is in metres (m). Resolutions less-than or equal-to this value will be returned. The resolution for Landsat-8 is 30 m. All climate/atmospheric datasets have a resolution of 0 m, because it is not applicable. The maximum resolution is 30 m. If resolution is omitted all imagery or data matching other search criteria will be returned.

Resolution must be 0 or greater, and can be a decimal value.

**max-cloudcover**

This maximum cloud cover field is only applicable to imagery that's available through the API (i.e. Landsat-8). Cloud cover is given as a percentage (%) of the image covered by cloud (0 to 100). Images less-than or equal-to this cloud cover value will be returned. All climate/atmospheric datasets have a cloud cover of 0%, because it is not applicable.If cloud cover is omitted all imagery or data matching other search criteria will be returned.

Cloud cover must be between 0 and 100 (inclusive), and can be a decimal value.

**wavelength-band**

Search criteria can be specified by the wavelength bands for imagery (i.e. Landsat-8) and by file type for non-imagery data (e.g. *Hierarchical-Data-Format*). 

Choices of bands are: *Blue, Cirrus, Coastal-Aerosol, Green, Hierarchical-Data-Format, Near-Infrared, Panchromatic, Red, Short-Wave-Infrared-1, Short-Wave Infrared-2, Thermal-Infrared-1, and Thermal-Infrared-2.* This field is not case-sensitive, and multiple bands can be specified (separated by commas).

### <h3 id="examples">Example API Calls</h3>

Examples of API calls and outputs can be found [HERE](https://github.com/skywatchspaceapps/api/blob/master/EXAMPLES.md).

### <h3 id="documentation">Dataset Documentation</h3>

The following list are links to documentation on the individual datasets available through the API:

* AIRS: [Version 6](http://disc.sci.gsfc.nasa.gov/AIRS/documentation/v6_docs):
  * [L3 data](http://disc.sci.gsfc.nasa.gov/AIRS/documentation/v6_docs/v6releasedocs-1/V6_L3_User_Guide.pdf)
* [GOSAT/ACOS](http://disc.sci.gsfc.nasa.gov/acdisc/documentation/ACOS.html)
  * [CAI L3 global radiance data](http://data.gosat.nies.go.jp/GosatUserInterfaceGateway/guig/doc/documents/GOSAT_ProductDescription_33_CAIL3_V2.00_en.pdf)
  * [FTS SWIR L3 data](http://data.gosat.nies.go.jp/GosatUserInterfaceGateway/guig/doc/documents/GOSAT_ProductDescription_31_FTSSWIRL3_V2.02_en.pdf)
* [MOPITT](http://www.acom.ucar.edu/mopitt/file-spec.shtml)
  * [L3 data](http://www2.acom.ucar.edu/sites/default/files/mopitt/v6_users_guide_201309.pdf)
* [OCO-2](http://disc.sci.gsfc.nasa.gov/OCO-2/documentation/oco-2-v6)
* [TES](https://eosweb.larc.nasa.gov/project/tes/tes_table)
  * [L3 data](http://tes.jpl.nasa.gov/uploadedfiles/TES_DPS_V11.8.pdf)

### <h3 id="hdf">HDF Documentation and Resources</h3>

The following list are links to documentation and resources that relate to HDF (Hierarchical Data Format; .hdf) (HDF4 and HDF5) file formats:

* [HDF5](https://www.hdfgroup.org/HDF5/) - all non-image datasets except AIRS
* [HDF4](https://www.hdfgroup.org/products/hdf4/) - all AIRS datasets
* Python libraries for HDF:
  * HDF5 - [h5py](http://www.h5py.org/)
  * HDF4 - [pyhdf](http://pysclint.sourceforge.net/pyhdf/)

### <h3 id="issues">Known Issues</h3>

* API calls that take longer than 30 seconds to complete will time out. We recommend refining your search criteria to be narrow enough to complete within 30 seconds.

### <h3 id="troubleshooting">Troubleshooting</h3>

For any issues or questions, please contact dexter@skywatch.co.
