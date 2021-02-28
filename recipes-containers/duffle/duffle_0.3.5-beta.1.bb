SUMMARY = "Duffle"
DESCRIPTION = "CNAB installer"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = "file://duffle-linux-amd64 \
           file://duffle-linux-arm64 \
           file://duffle-linux-arm \
"

S = "${WORKDIR}"

require duffle-bin-arch.inc

do_install() {
    # Install binary
    install -d ${D}${bindir}
    install -m 755 ${S}/duffle-linux-${DUFFLE_PKG_ARCH} ${D}${bindir}/duffle
}

FILES_${PN} += " \
    ${bindir}/duffle \
"