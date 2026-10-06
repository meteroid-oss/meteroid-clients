from importlib.metadata import PackageNotFoundError, version

try:
    __version__ = version("meteroid")
except PackageNotFoundError:
    __version__ = "0+uninstalled"
