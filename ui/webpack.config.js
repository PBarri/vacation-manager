/**
 * Created by pablo on 8/11/16.
 */
'use strict';

// Modules
var webpack = require('webpack');
var autoprefixer = require('autoprefixer');
var HtmlWebpackPlugin = require('html-webpack-plugin');
var ExtractTextPlugin = require('extract-text-webpack-plugin');
var CopyWebpackPlugin = require('copy-webpack-plugin');

const path = require('path');
const rootDir = path.resolve(__dirname);

module.exports = {
    resolve: {
        extensions: ['', '.js', '.css'],
        alias: {
            moment: 'moment/moment.js'
        },
        modulesDirectories: ['node_modules', 'app', 'bower_components']
    },
    entry: {
        app: ['./app/app.js', './app/components.js', './app/services.js', './app/views.js'],
        styles: ['./app/styles.css'],
        vendor: ['./app/vendor.js'],
        base: ['./app/vendors.css']
    },
    debug: true,
    devtool: 'eval-source-map',
    output: {
        path: path.resolve(rootDir, 'dist'),
        filename: '[name].js',
        sourceMapFilename: '[name].map',
        publicPath: '/vacation-manager'
    },
    module: {
        loaders: [
            {
                test: /\.css$/,
                loader: ExtractTextPlugin.extract("style-loader", "css-loader")
            },
            {
                test: /\.(png|jpg|jpeg|gif|svg|woff|woff2|ttf|eot)$/,
                loader: 'file'
            }, {
                test: /\.html$/,
                loader: 'raw'
            }
        ]
    },
    postcss: function() {
      return [autoprefixer];
    },
    plugins: [
        new webpack.optimize.CommonsChunkPlugin("vendor", "vendor.js"),
        new ExtractTextPlugin('[name].css'),
        new HtmlWebpackPlugin({
            template: 'app/index.html'
        }),
        new webpack.optimize.UglifyJsPlugin(),
        new CopyWebpackPlugin([
            {
                from: 'app/resources',
                to: 'resources'
            },
            {
                from: 'app/WEB-INF',
                to: 'WEB-INF'
            }
        ]),
        new webpack.optimize.DedupePlugin()
    ],
    devServer: {
        contentBase: path.resolve(rootDir, 'dist'),
        stats: 'minimal',
        port: '8000'
    }
};