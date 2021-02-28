SUMMARY = "Skopeo"
DESCRIPTION = "Tool used for manipulating and transferring containers (including binary-delta support)."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = "file://skopeo-linux-amd64 \
           file://skopeo-linux-arm64 \
           file://policy.json \
           file://storage.conf \
"

S = "${WORKDIR}"

inherit systemd distro_features_check
require skopeo-bin-arch.inc

do_install() {
    # Install binary
    install -d ${D}${bindir}
    install -m 755 ${S}/skopeo-linux-${SKOPEO_PKG_ARCH} ${D}${bindir}/skopeo

    # Install configs
    install -d ${D}${sysconfdir}/containers
    install -Dm0644 ${S}/policy.json ${D}${sysconfdir}/containers/policy.json
    install -Dm0644 ${S}/storage.conf ${D}${sysconfdir}/containers/storage.conf
}

FILES_${PN} += " \
    ${bindir}/skopeo \
    ${sysconfdir}/containers/policy.json \
    ${sysconfdir}/containers/storage.conf \
"