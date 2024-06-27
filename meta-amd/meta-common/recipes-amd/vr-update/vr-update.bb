SUMMARY = "VR Update application"
DESCRIPTION = "Used for performing VR updates through BMC"

FILESEXTRAPATHS:prepend := "${THISDIR}:"

LICENSE = "CLOSED"

inherit cmake pkgconfig systemd

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

SRC_URI = "git://github.com/AMDESE/vr-firmware-update.git;protocol=https;branch=main"
SRCREV = "9cbe4a51bc475638da4c6f2db94f4576cb546df4"

SRC_URI += "\
            file://0001-Fix-i2c_smbus_read_i2c_block_data-return-value-check.patch \
            file://0002-Switch-to-CPP20.patch \
            "

S = "${WORKDIR}/git"

INSANE_SKIP:${PN} += "ldflags"
RDEPENDS:${PN} += "bash"

do_install() {
        install -d ${D}${sbindir}
        install -m 0755 vr-update ${D}${sbindir}
        install -m 0755 ${S}/config/vr-config-info ${D}/${sbindir}/
}
