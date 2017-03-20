'use strict';

Object.defineProperty(exports, "__esModule", {
  value: true
});

var _colors = require('material-ui/styles/colors');

var _colorManipulator = require('material-ui/utils/colorManipulator');

var _spacing = require('material-ui/styles/spacing');

var _spacing2 = _interopRequireDefault(_spacing);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

exports.default = {
  spacing: _spacing2.default,
  fontFamily: 'Roboto, sans-serif',
  palette: {
    primary1Color: _colors.blueGrey800,
    primary2Color: _colors.blueGrey800,
    primary3Color: _colors.blueGrey700,
    accent1Color: '#0C4E4C', // _colors.tealA200,
    accent2Color: '#41817F',// _colors.tealA400,
    accent3Color: '#679B99',// _colors.tealA100,
    textColor: _colors.darkWhite,
    secondaryTextColor: (0, _colorManipulator.fade)(_colors.darkWhite, 0.7),
    alternateTextColor: _colors.lightWhite,
    canvasColor: _colors.blueGrey400,
    borderColor: (0, _colorManipulator.fade)(_colors.fullWhite, 0.3),
    disabledColor: (0, _colorManipulator.fade)(_colors.fullWhite, 0.3),
    pickerHeaderColor: (0, _colorManipulator.fade)(_colors.fullWhite, 0.12),
    clockCircleColor: (0, _colorManipulator.fade)(_colors.fullWhite, 0.12)
  }
};