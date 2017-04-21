# Uart Bridge App

## Summary

The point of this app is to bridge Uart data read from a Uart (serial port) device connected to
an Android devices USB port through to a network socket.

The initial primary use-case is to allow a Vario/GPS instrument to be used by XCSoar/Tophat on 
Android devices where XCSoar/Tophat do not support using Androids USB Host APIs to read from 
usb-attached varios that provide NMEA sentences via a serial (UART) connection over USB. But
XCSoar/Tophat do have the functionality to read the data from a TCP network port.



## Credits

* All credit for this idea goes to Alistair Dickie as 
[documented in his blog post](http://blueflyvario.blogspot.com.au/2016/04/blueflyvariottlgps-over-usb-on-android.html)
* [UsbSerial library](https://github.com/felHR85/UsbSerial)
