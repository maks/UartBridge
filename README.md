# Uart Bridge App

## Summary

The point of this app is to bridge serial data read from a UART (serial port) device connected to an
Android devices USB port through to a network socket.

The initial use-case is to allow a Vario/GPS instrument to be used by XCSoar/Tophat on Android 
devices as XCSoar/Tophat do not support using the Android USB Host API to read from USB-attached 
varios that provide NMEA sentences output via a serial connection over USB. But XCSoar/Tophat do 
have the functionality to read the data from a TCP network port.

Available on Google Play: <a href='https://play.google.com/store/apps/details?id=com.manichord.uartbridge&hl=en&pcampaignid=MKT-Other-global-all-co-prtnr-py-PartBadge-Mar2515-1'><img alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png'/></a>


## Credits

* All credit for this idea goes to Alistair Dickie as 
[documented in his blog post](http://blueflyvario.blogspot.com.au/2016/04/blueflyvariottlgps-over-usb-on-android.html)
* [UsbSerial library](https://github.com/felHR85/UsbSerial)
* Icon: Serial to USB by Bonegolem from the Noun Project
