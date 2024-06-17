SUMMARY = "AMD RAS application to handle RAS errors from BMC"
DESCRIPTION = "The applications harvests and handles the RAS errors from the processor"

LICENSE = "CLOSED"

FILESEXTRAPATHS:prepend := "${THISDIR}:"

inherit meson
inherit pkgconfig
inherit systemd
inherit phosphor-mapper

def get_service(d):
    return "com.amd.crashdump.service"

SYSTEMD_SERVICE:${PN} = "${@get_service(d)}"
SRC_URI = "git://github.com/AMDESE/amd-bmc-ras.git;protocol=https;branch=main"
SRCREV = "006f8134a7586f76e2b15528fd01d960d0169441"

S = "${WORKDIR}/git"

DEPENDS += " \
    amd-apml \
    i2c-tools \
    phosphor-dbus-interfaces \
    phosphor-logging \
    sdbusplus \
    libgpiod \
    boost \
    nlohmann-json \
    "

FILES:${PN} += "${systemd_unitdir}/system/com.amd.crashdump.service"
