# SkyWatch API v0.2
### Overview
Through the API you can access the following climate and atmospheric datasets:
* [AIRS](http://www.skywatch.co/airs) (Level 2 and 3)
* [GOSAT/ACOS](http://www.skywatch.co/gosat) (Level 2 and 3)
* [MOPITT](http://www.skywatch.co/mopitt) (Level 1 and 3)
* [OCO-2](http://www.skywatch.co/oco2) (Level 2 only)
* [TES](http://www.skywatch.co/tes) (Level 2 and 3)

You can use the API to search datasets by data level, location, and date. The JSON response will return a signed URL to download the datasets that meet the search criteria.

### API Usage
```curl -H "x-api-key: <api key>" https://cqh77pglf1.execute-api.us-west-2.amazonaws.com/prod/data/level/<level>/location/<coordinates>/time/<times>```

Where:

**api key**

A personal alphanumeric api key will be provided to you upon request. If you weren’t provided a key, or have any issues using the key provided, please contact dexter@skywatch.co.

**level**

The data level is an optional path of the API URL that corresponds to the [data processing levels](http://science.nasa.gov/earth-science/earth-science-data/data-processing-levels-for-eosdis-data-products/) for Earth observation data. Level 1, 2, and 3 (L1, L2, L3) datasets are available. If no data level is specified, datasets of all levels will be returned.

**coordinates**

A list of longitude, latitude coordinate pairs as a flat, comma-separated list. A list of two numbers represents a point, four numbers is a square area where the coordinates are the corners, or if there are more than four numbers the coordinates represent a closed polygon, where the first point equals the last point in the list. Because this list represents a number of points, there always has to be an even number of numbers in the list.

*Examples:* 
* Point: -71.1043443253,-42.3150676016
* Square:  -71.1043443253471,-42.3150676015829,71.1043443253471,42.3150676015829
* Polygon: -71.1043443253471,-42.3150676015829,71.1043443253471,-42.3150676015829,71.1043443253471,42.3150676015829,-71.1043443253471,42.3150676015829,-71.1043443253471,-42.3150676015829

**times** 

One or two UTC timestamps in ISO format (yyyy-mm-ddThh:mm:ss.sssss+|-zzzz). Partial dates can also be specified: 2009, 2009-12, 2009-12-25, 2009-12-25T13:25:00.0000+0000. If no time is specified, midnight UTC on the day in question is assumed. 

If only one timestamp is passed in, a one day range is assumed. For example, if 2009-12-25 is specified, the search takes place as if 2009-12-25,2009-12-26 was specified.

### Example API Call

```curl -H "x-api-key: 1a2b3c4d5e6f7g8h9i0j1k2l3m4n5o6p" https://cqh77pglf1.execute-api.us-west-2.amazonaws.com/prod/data/level/2/location/-71.1043443253471,-42.3150676015829/time/2009-12-25```

```curl -H "x-api-key: 1a2b3c4d5e6f7g8h9i0j1k2l3m4n5o6p" https://cqh77pglf1.execute-api.us-west-2.amazonaws.com/prod/data/location/-71.1043443253471,-42.3150676015829/time/2009-12-25```

If you get a status 200, you will receive a JSON list of CO2 satellite data files that match the criteria, their sizes, and signed URL to download. The signed URLs **expire 1 hour after being generated.**

*Excerpt of a JSON response:*
```
[
    {
        "size": 159422423,
        "download_path": "https://skywatch-data.s3.amazonaws.com/AQUA/AIRS-L3/AIRS3STD/2009/AIRS.2009.12.27.L3.RetStd_IR001.v6.0.9.0.G14016120737.hdf?Signature=n6dcWJ%2FImeny6n6nCMiIENL4JNo%3D&Expires=1472781464&AWSAccessKeyId=AKIAJSPB2ROCVRJJ2BMQ"
    },
    {
        "size": 159084071,
        "download_path": "https://skywatch-data.s3.amazonaws.com/AQUA/AIRS-L3/AIRS3STD/2009/AIRS.2009.12.27.L3.RetStd_IR001.v6.0.9.0.G14016120737.hdf?Signature=n6dcWJ%2FImeny6n6nCMiIENL4JNo%3D&Expires=1472781464&AWSAccessKeyId=AKIAJSPB2ROCVRJJ2BMQ"
    }
]
```
**Downloading the Data**

Each signed URL can be directly downloaded through a browser or programmatically, which expires **1 hour** after being generated.

**Dataset Documentation**

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

**HDF Documentation and Resources**

The following list are links to documentation and resources that relate to HDF (Hierarchical Data Format; .hdf) (HDF4 and HDF5) file formats:

* [HDF5](https://www.hdfgroup.org/HDF5/) - all non-image datasets except AIRS
* [HDF4](https://www.hdfgroup.org/products/hdf4/) - all AIRS datasets
* Python libraries for HDF:
  * HDF5 - [h5py](http://www.h5py.org/)
  * HDF4 - [pyhdf](http://pysclint.sourceforge.net/pyhdf/)

**Troubleshooting**

For any issues or questions, please contact dexter@skywatch.co.
