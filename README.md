# meta-radxa

This is a minimal Yocto/OpenEmbedded layer that defines a custom DISTRO named **`radxa`**.

> ⚠️ This layer does **not** define any machine configurations.  
> Instead, it relies on external BSP layers like `meta-rockchip` to provide supported machines.

---

## Features

- Defines a custom `DISTRO` called `radxa`
- Provides a `setup-environment.sh` script that:
  - Automatically scans available machine configurations from BSP layers
  - Prompts the user to select one interactively
  - Initializes the build environment
  - Populates `local.conf`, `bblayers.conf`, and includes `radxa.conf` in `DISTRO`

---

## Usage

### 1. Clone into your Yocto workspace

```bash
git clone https://github.com/<your-username>/meta-radxa.git
