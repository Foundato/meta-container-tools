SUMMARY = "CNAB-to-OCI"
DESCRIPTION = "CNAB to oci converter"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = "file://cnab-to-oci-linux-amd64 \
           file://cnab-to-oci-linux-arm64 \
           file://cnab-to-oci-linux-arm \
"

S = "${WORKDIR}"

require cnab-to-oci-bin-arch.inc

do_install() {
    # Install binary
    install -d ${D}${bindir}
    install -m 755 ${S}/cnab-to-oci-linux-${CNAB_TO_OCI_PKG_ARCH} ${D}${bindir}/cnab-to-oci
}

FILES_${PN} += " \
    ${bindir}/cnab-to-oci \
"