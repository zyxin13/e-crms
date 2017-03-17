"use strict";
require.config({
    baseUrl: "./js",
    paths: {
        jquery: "lib/jquery-3.1.1",
        backbone: "lib/backbone",
        underscore: "lib/underscore",
        text: "lib/text",
    },
});
require(["routers"], function(Routers) {
	new Routers();
});