# frontend
ADITest is an exercise project for front-end application that read images from flickr and display them.

My implementation is using Flickr Java API to search images
 - Search all images uploaded by some one by paging
 - Search a specific image by ID
 - Search an image by match in Title (Not yet implemented)

Then the application becomes 3 layers:
 - Model layer will define a Photo object which act as a bean that representing the images queried out from Flickr
 - Control layer is the REST services that transfer query to Flickr and return Photo object in Json
 - View layer will present the data
 
The Web UI determine what kind of services are needed or even what kind of information is must-have in model. 
In this project, I have a banner which provide fuzzy query against all images (not yet implemented). The left menu will provide paging capabilities while the right side will be used to dispay all images in a page. Those images should be small ones and a large image should be poped up when mouse go over the image.

So model layer should have definition of
  - ID
  - Title
  - Discription
  - Small image url
  - Large image url
Those features should be enough for now.

The control layer will expose 3 search REST API as described above.

The UI will
  - Provide fuzzy query widget (Not yet implemented)
  - A fixed location memu
  - A updated content when page change (Blocked by the issue that $scope update but UI not refreshed)
  - A hiden widget that will display big image and display it when mouse go over the small one (Blocked by the issue of mouse event)

What can improve?
  - Find another way to compose menu so that move paging related button to the bottom of the UI.
  - Extend the page to show more pictures instead of replace original ones.
  - UT, build are not ready
  - Code is not strong enough, e.g. invalid parameter check might not created
  - Integration test cases are not defined
  - I18N not supported
  - Security is not considered
