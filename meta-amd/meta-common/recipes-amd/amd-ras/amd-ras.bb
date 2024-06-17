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
SRC_URI = "git://git@github.com:/AMDESE/amd-bmc-ras.git;branch=main;protocol=ssh"
SRCREV = "${AUTOREV}"

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
