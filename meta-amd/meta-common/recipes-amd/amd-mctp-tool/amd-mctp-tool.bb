SUMMARY = "AMD MCTP over PCIe test tool"
DESCRIPTION = "It allows to test the MCTP protocole over PCIe VDM"

FILESEXTRAPATHS:prepend := "${THISDIR}:"

LICENSE = "CLOSED"

SRC_URI = "file://amd-mctp-tool.c \
           file://amd-mctp-tool.h \
          "
DEPENDS += "libmctp-intel"
S = "${WORKDIR}"

INSANE_SKIP:${PN} += "ldflags"
RDEPENDS:${PN} += "bash"

do_compile() {
    ${CXX} amd-mctp-tool.c -o amd-mctp-tool -lmctp_intel
}

do_install() {
        install -d ${D}${bindir}
        install -m 0755 amd-mctp-tool ${D}${bindir}
}
