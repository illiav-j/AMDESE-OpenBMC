SUMMARY = "AMD EPYC System Management Interface Library"
DESCRIPTION = "AMD EPYC System Management Interface Library for user space APML implementation"

FILESEXTRAPATHS:prepend := "${THISDIR}:"

LICENSE = "CLOSED"

DEPENDS += "i2c-tools"
DEPENDS += "i3c-tools"
RDEPENDS:${PN} += "bash"

SRC_URI += "git://github.com/amd/apml_library.git;protocol=https;branch=master"
#SRC_URI += "git://github.com/amd/esmi_oob_library.git;protocol=https;branch=master"
SRCREV = "5327a39ddc244eaf69794c5a57d5fd5a5bbe3a87"

SRC_URI += "file://0001-amd-apml-Enable-apml-library-with-i3c.patch \
            file://0002-amd-apml-select-APML-over-i2c-i3c.patch  \
            file://0003-amd-apml-Add-i2c-bind-unbind.patch \
           "

S="${WORKDIR}/git"

inherit cmake

do_install () {
        install -d ${D}${libdir}
        cp --preserve=mode,timestamps -R ${B}/libapml* ${D}${libdir}/

        install -d ${D}${bindir}
        install -m 0755 ${B}/apml_cpuid_tool ${D}${bindir}/
        install -m 0755 ${B}/apml_tool ${D}${bindir}/
        install -m 0755 ${S}/scripts/set-apml.sh ${D}${bindir}/

        install -d ${D}${includedir}
        install -m 0644 ${S}/include/esmi_oob/* ${D}${includedir}/
}
