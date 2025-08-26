# meta-radxa

This is a minimal Yocto/OpenEmbedded layer that defines a custom DISTRO named **`radxa`**.

> ⚠️ This layer does **not** define any machine configurations.
> Instead, it relies on external BSP layers like `meta-rockchip` to provide supported machines.

---

## Features

* Defines a custom `DISTRO` called `radxa`
* Provides a `setup-environment.sh` script that:

  * Automatically scans available machine configurations from BSP layers
  * Prompts the user to select one interactively
  * Initializes the build environment
  * Populates `local.conf`, `bblayers.conf`, and includes `radxa.conf` in `DISTRO`

---

## Usage

### 1. Clone into your Yocto workspace

```bash
git clone https://github.com/AidenPearce1918/meta-radxa.git
```

Ensure that other required layers like `meta-rockchip` are also available.

---

### 2. Source the setup script

```bash
source meta-radxa/setup-environment.sh
```

You will be prompted to:

* Enter a build directory name
* Select a machine (automatically scanned)

The script will then:

* Create the build directory (if not existing)
* Copy and configure `local.conf`, `bblayers.conf`, and `radxa.conf`
* Set up the environment for you to start building

---

### 3. Build an image

```bash
bitbake core-image-minimal
```

---

## Layer Structure

```
meta-radxa/
├── COPYING.MIT
├── README.md
├── conf
│   ├── distro
│   │   └── radxa.conf
│   ├── layer.conf
│   └── templates
│       ├── bblayers.conf.sample
│       └── local.conf.sample
├── recipes-core
│   └── images
│       ├── core-image-base.bbappend
│       └── core-image-minimal.bbappend
├── recipes-networking
│   └── aic8800
│       └── aic8800.bb
└── setup-environment
```

---

## Requirements

* Poky / Yocto base
* Compatible BSP layer (e.g., `meta-rockchip`) that defines machine configurations

---

## Available Targets

After sourcing the environment, you can run:

```bash
bitbake <target>
```

Some common targets include:

* `core-image-minimal`
* `core-image-full-cmdline`
* `core-image-sato`
* `core-image-weston`
* `meta-toolchain`
* `meta-ide-support`

---

## License

This layer is licensed under the MIT License.
See [`COPYING.MIT`](COPYING.MIT) for full details.

