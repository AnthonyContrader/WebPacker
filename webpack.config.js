const HtmlWebpackPlugin = require('html-webpack-plugin');
const path = require('path')
var webpackConfig = {
  mode:"development",
  entry: {
    main: './src/main.ts'
  }, resolve: {
    extensions: ['.ts', '.js']
  },
  output: {
    filename: 'bundle.js',
    path: path.join(__dirname, 'src', 'dist'),
  },
  module: {
    rules: [{
      test: /\.ts$/,
      use: ['awesome-typescript-loader', 'angular2-template-loader']
    },
    {
      test: /\.html$/,
      use: 'html-loader'
    },
    {
      test: /\.svg$/,
      use: 'file-loader'
    },
    {
      test: /\.css$/,
      use: [
        'to-string-loader', 'css-loader',
      ],
    },
    ]
  },
  devServer: {
  //writeToDisk: true,
  //contentBase: './dist',
  port: 4200
  },
};
const htmlWebpackPlugin = new HtmlWebpackPlugin({
  template: './src/index.html',
});
webpackConfig.plugins = [
  htmlWebpackPlugin,
];
module.exports = webpackConfig;